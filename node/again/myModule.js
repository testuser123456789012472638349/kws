
///////////////////CJS 방식
// exports.myDateTime = function () {
//     return Date();
// };

// exports.sayHello = function(userName) {
//     console.log('안녕~ ' + userName + "!");
// };

// module.exports = {
//     myDateTime : function () {
//         return Date();
//     },
//     sayHello : function(userName) {
//         console.log('안녕~ ' + userName + "!");
//     }   
// };

/////////////////////UMD 방식
function myDateTime() {
    return Date();
};

function sayHello(userName) {
    console.log('안녕~ ' + userName + "!");
};

//대표적인 것 하나 전송
export default {
    totalFunc: function(userName) {
        console.log(myDateTime());
        sayHello(userName);
    },
    someValue: 100
};

export {myDateTime, sayHello};