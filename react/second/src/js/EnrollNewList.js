function EnrollNewList({pdname, manage, pdamount, allow, price, onChange}) {
    return (
        <div>
            <input
                name="pdname"
                placeholder="상품명"
            />
            <input
                name="manage"
                placeholder="상품 단위 수준의 재고 관리"
            />
            <input
                name="pdamount"
                placeholder="재고수량"
            />
            <input
                name="allow"
                placeholder="품절 후 주문 허용여부"
            />
            <input
                name="price"
                placeholder="전체 입계값"
            />
            <button>삭제</button>
        </div>
    );
}

export default EnrollNewList;