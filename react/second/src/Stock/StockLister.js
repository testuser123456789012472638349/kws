import StockItem from "./StockItem";
import "./StockLister.css";

function StockLister({stocks, search, isModify, onDelStocks}) {
    return (
        <table className="stock-lister">
            <thead>
                <tr>
                    <th>상품명</th>
                    <th>관리유무</th>
                    <th>재고수량</th>
                    <th>주문허용</th>
                    <th>기준값</th>
                    <th>수정</th>
                    <th>삭제</th>
                </tr>
            </thead>
            <tbody>
                {
                    stocks.sort((a, b) => {
                        if(b.productName > a.productName) {
                            return -1;
                        } 
                        return 0;
                    }).filter(stock => {
                        if(search)
                            return stock.productName.indexOf(search) !== -1;
                        else 
                            return stock;
                    }).map((stock, i) => {
                        return <StockItem 
                                    key={stock.productId}
                                    tr={i}
                                    stock={stock} 
                                    onDelStocks={onDelStocks}
                                    isModify={isModify} />;
                    })
                }
            </tbody>
        </table>
    );
}

export default StockLister;
