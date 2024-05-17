import React, { useRef, useState } from "react";
import '../css/Temptest.css';
// import EnrollNewList from "./EnrollNewList";



function Temptest() {
        // function EnrollList({enrolls}) {
        //     const { pdname, manage, pdamount, allow, price } = enrolls;
        //     const temp = [
        //         {
        //             id:1,
        //             pdname: '',
        //             manage: '',
        //             pdamount: '',
        //             allow: '',
        //             price: '',
        //         }
        //     ];
        //     const [enrolls, setEnrolls] = useState(temp);
        // }
        // const nextPd = useRef(2)

        
        
        // const onChange = e => {
        //     const {pdname, value} = e.target;
        //     setEnroll({
        //         ...enroll,
        //         [pdname]: value
        //     });
        // };

        return (
            <>
                <div id="wrap">
                    <div id="pd-d">상품 데이터
                        <select>
                            <option>옵션 상품</option>
                            <option>비옵션 상품</option>
                        </select>
                    </div>
                    <div id="main">
                        <div id="left">
                            <div>재고</div>
                            <div>배송</div>
                            <div>연결된 상품</div>
                            <div>속성</div>
                            <div>옵션</div>
                            <div>고급</div>
                        </div>
                        <div id="center">
                            <div>상품명</div>
                            <div>본 상품의 재고를 관리하십니까?</div>
                            <div>재고 수량</div>
                            <div>품절 후 주문을 허용합니까?</div>
                            <div>재고 소진 경고 기준값</div>
                        </div>
                        <div id="right">
                            <div><input type="text" placeholder="상품명을 입력 요망"name="pdname"></input></div>
                            <div><input type="checkbox" checked></input>상품 단위 수준에서 재고 관리</div>
                            <div><input type="text" placeholder="20"></input></div>
                            <div>
                                <select>
                                    <option>허용하지 않음</option>
                                    <option>허용함</option>
                                </select>
                                </div>
                            <div><input type="text" placeholder="스토어 전체 입계값(2)"></input></div>
                        </div>
                        <div id="enroll"><button>등록</button></div>
                    </div>
                </div>
                {/* <EnrollNewList
                    pdname={pdname}
                    manage={manage}
                    pdamount={pdamount}
                    allow={allow}
                    price={price}
                    onChange={onChange}
                    // onCreate={onCreate}
                /> */}
            </>
           
        );
    }

export default Temptest;


// <enrollList pdamount={pdamount} /> <enrollList totalprice={totalprice} />