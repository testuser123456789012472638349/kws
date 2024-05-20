import "./StockItem.css";

function StockItem({stock, tr, onDelStocks, isModify}) {
    const { productId, 
            productName, 
            productManage, 
            productCount, 
            productAfter, 
            productStandard} = stock;
    return (
        <tr style={tr % 2 !== 0 ? {backgroundColor: 'white'} : {backgroundColor: 'lightgoldenrodyellow'}}>
            <td>{productName}</td>
            <td>{productManage ? 'Y' : 'X'}</td>
            <td>{productCount}</td>
            <td>{productAfter ? 'Y' : 'X'}</td>
            <td>{productStandard}</td>
            <td><button onClick={() => isModify(productId)}><img src="https://w7.pngwing.com/pngs/818/878/png-transparent-computer-icons-editing-symbol-symbol-miscellaneous-angle-text-thumbnail.png" alt="수정" /></button></td>
            <td><button onClick={() => onDelStocks(productId)}><img src="https://w7.pngwing.com/pngs/953/119/png-transparent-computer-icons-delete-icon-cdr-angle-text-thumbnail.png" alt="삭제"></img></button></td>
        </tr>
    )
}

export default StockItem;