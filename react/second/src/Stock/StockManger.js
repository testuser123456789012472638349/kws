import { useRef, useState } from "react";
import StockInputer from "./StockInputer";
import StockLister from "./StockLister";

import "./StockManager.css";
import StockSearcher from "./StockSearcher";

/*
    stock
    {
        productId: intger
        productName: string,
        productManage: boolean,
        productCount: integer,
        productAfter: boolean,
        productStandard: integer
    }
*/

function StockManger() {
    const initStock = {
        productId: 0,
        productName: '',
        productManage: false,
        productCount: 0,
        productAfter: true,
        productStandard: 0
    }
    const [stocks, setStocks] = useState([]);
    const [stock, setStock] = useState(initStock);
    const [modify, setModify] = useState(false);
    const [search, setSearch] = useState('');

    const inputProductName = useRef();
    const stockId = useRef(1);

    const onChangeStock = e => {
        const value = e.target.name === "productManage" ? 
                        !stock.productManage : 
                        e.target.name === "productAfter" ? 
                        e.target.value === 'true' : e.target.value;

        setStock({
            ...stock,
            productId: modify ? stock.productId : stockId.current,
            [e.target.name]: value
        });
    };

    const onAddStocks = () => {
        if(stock.productName === '') {
            alert('상품명 입력 필수');
            inputProductName.current.style.backgroundColor = 'lightgreen';
            inputProductName.current.focus();
            return;
        }
                
        setStocks([
            ...stocks,
            stock
        ]);
        setStock(initStock);
        inputProductName.current.style.backgroundColor = 'transparent';
        inputProductName.current.focus();

        stockId.current += 1;
    };

    const onDelStocks = id => {
        const fs = stocks.find(stock => stock.productId === id);
        let isDelete = window.confirm(`${fs.productName}을(를) 삭제하시겠습니까?`);
        if(isDelete) {
            setStocks(stocks.filter(stock => stock.productId !== id));
        }
    };

    const isModify = id => {
        if(id === 0) {
            setStock(initStock);
            setModify(!modify);
        } else {
            const fs = stocks.find(stock => stock.productId === id);
            setStock(fs);
            setModify(true);
        }
    };

    const onModify = () => {
        setStocks(
            stocks.map(s => {
                return s.productId === stock.productId ? stock : s
            })
        );
        isModify(0);
    };

    const onSearch = e => {
        if(typeof e === 'string') {
            setSearch(e);
            return;
        } 
        setSearch(e.target.value);
    }

    return (
        <div className="stock-manager">
            <h1>상품 제고관리</h1>
            <StockInputer 
                stock={stock} 
                modify={modify}
                inputProductName={inputProductName}
                onChange={onChangeStock} 
                onAddStocks={onAddStocks}
                isModify={id => isModify(id)}
                onModify={onModify} />
            <StockSearcher onSearch={onSearch} />
            <StockLister 
                stocks={stocks}
                search={search}
                onDelStocks={id => onDelStocks(id)}
                isModify={id => isModify(id)} />
        </div>
    );
}

export default StockManger;