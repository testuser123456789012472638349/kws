import { useRef } from 'react';
import './StockSearcher.css';

function StockSearcher({onSearch}) {
    const inputSearch = useRef();

    const handleSearch = () => {
        if(inputSearch.current.value === '') return;
        onSearch(inputSearch.current.value);
    }

    return (
        <div className="stock-searcher">
            <div><input type="text" placeholder='SEARCH...' onChange={onSearch} ref={inputSearch} /></div>
            <div><button onClick={handleSearch}><img src="https://e7.pngegg.com/pngimages/10/880/png-clipart-computer-icons-search-box-magnifying-glass-black-and-white-tool.png" alt="검색" /></button></div>
        </div>
    );
}

export default StockSearcher;