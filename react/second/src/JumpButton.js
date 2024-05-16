import React from "react";
import './JumpButton.css';

// class JumpButton extends React.Component {
//     render() {
//         const desc = this.props.desc;
//         return <button onClick={this.props.onClick}>{desc}</button>;
//     }
// }

function JumpButton({desc, onClick}) {
    return <button onClick={onClick}>{desc}</button>;
}

export default JumpButton;