import "./StockInputer.css";

function StockInputer({stock, 
                        modify, 
                        inputProductName, 
                        onChange, 
                        onAddStocks, 
                        isModify, 
                        onModify}) {
    const { 
            productName,
            productManage,
            productCount,
            productAfter,
            productStandard } = stock;
    return (
        <div className="stock-inputer">
            <div>
                <label>
                    <span>상품명</span>
                    <input 
                        type="text" 
                        name="productName"
                        ref={inputProductName} 
                        value={productName}
                        onChange={onChange} />
                </label>
            </div>
            <div>
                <label>
                    <span>본 상품의 재고를 관리합니까?</span>
                    <input 
                        type="checkbox" 
                        name="productManage"
                        checked={productManage} 
                        onChange={onChange} />
                </label>
            </div>
            <div>
                <label>
                    <span>재고 수량</span>
                    <input 
                        type="number" 
                        name="productCount"
                        value={productCount}
                        onChange={onChange} />
                </label>
            </div>
            <div>
                <label>
                    <span>품절 후 주문을 허용합니까?</span>
                    <select name="productAfter" onChange={onChange} value={productAfter}>
                        <option value={true}>허용 함</option>
                        <option value={false}>허용하지 않음</option>
                    </select>
                </label>
            </div>
            <div>
                <label>
                    <span>재고 소진 경고 기준값</span>
                    <input type="number" 
                            name="productStandard" 
                            placeholder="스토어 전체 임계값(2)"
                            value={productStandard}
                            onChange={onChange}/>
                </label>
            </div>
            <div>
                {
                    modify ? 
                        <>
                            <button onClick={onModify}>수정</button>
                            <button onClick={() => isModify(0)}>취소</button>
                        </>
                    :   <button onClick={onAddStocks}>등록</button>
                }
            </div>
        </div>
    );
}

export default StockInputer;