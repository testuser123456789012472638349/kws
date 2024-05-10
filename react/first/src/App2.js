import { Fragment } from "react";
import Hello from "./Hello";

function App2() {
    const name = 'react';

    return (
        <Fragment>
            <Hello />
            <div>asd</div>
        </Fragment>
    );
}

export default App2;