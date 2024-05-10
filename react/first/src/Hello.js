/* 
    객체 만드는 방법
    1. 리터럴 방식 {}
    2. 생성자 함수
    3. class 키워드 사용
*/
import "./Hello.css";

function Hello(userType) {
    // console.log(userType.children);
    
    //구조분해 할당
    let {name, color, fsize, userObject, onClick, children, isSpecial} = userType;

    if(isSpecial === 'test') isSpecial = true;
    else isSpecial = false;

    color = color ? color : 'green';
    
    return (
            <div style={{color: color, fontSize: fsize}} onClick={onClick}>
                <img src={userObject.userImg} alt={name && "박길동"} width={userObject['userAge']} />
                {isSpecial && <b>*</b>}
                {name} 안녕하세요.
                {children}
            </div>
    );
}

// Hello.defaultProps = {
//     name: '박길동',
//     color: 'green' 
// };

export default Hello;
