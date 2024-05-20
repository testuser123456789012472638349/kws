import { useRef, useState } from "react";
import User from "./User";
import CreateUser from "./CreateUser";

function UserList() {
    const temp = [
        {
            id: 1,
            username: 'velopert',
            email: 'public.velopert@gmail.com',
            active: false
        },
        {
            id: 2,
            username: 'tester',
            email: 'tester@example.com',
            active: false
        },
        {
            id: 3,
            username: 'liz',
            email: 'liz@example.com',
            active: false
        },
        {
            id: 4,
            username: 'liz2',
            email: 'liz2@example.com',
            active: false
        }
    ];

    const [users, setUsers] = useState([]);
 
    const [inputs, setInputs] = useState({
        username: '',
        email: ''
    });
    const {username, email} = inputs;
    const onChange = e => {
        const {name, value} = e.target;
        setInputs({
            ...inputs,
            [name]: value
        });
    }

    const nextId = useRef(5);

    const onCreate = () => {
        const user = {
            id: nextId.current,
            username: username,
            email: email,
            active: false //추가
        };

        //users.push(user);
        //console.log(users);
        setUsers(users.slice().concat(user));
        // setUsers([
        //     ...users,
        //     user
        // ]);
        //console.log(users);

        setInputs({
            username: '',
            email: ''
        });

        nextId.current += 1;
    }


    //이유없이 잘됨....
    //이전 에러: a component is changing an uncontrolled input to be controlled
    const onToggle = id => {
        setUsers(users.map((val, i, arr) => 
            val.id === id ? {
                ...val,
                active: !val.active
            } : val
            
            // if(val.id === id) {
            //     let user = Object.assign({}, val);
            //     user.active = !val.active;
            //     console.log(user);
            //     return user;
            // }

            // return val.id === id ? {...val, active: !val.active} : val
            
            //console.log(user)
        ));
        console.log(users);

        // const nowIndex = id - 1;
        // const arr = users.slice();
        // const user = arr[nowIndex];
        // user.active = !arr[nowIndex].active;
        // arr[nowIndex] = user;
        // setUsers(arr);
        return;

        const newUsers = users.map((val, i, arr) => {
            return val.id === id ? {
                ...val,
                active: !val.active
            } : val;
            // if(val.id === id) {
            //     return {
            //         ...val,
            //         active: !val.active
            //     }
            // }
            // return val;
        });
        setUsers(newUsers);
    }

    const onRemove = id => {
        setUsers(users.filter(user => user.id !== id));
        // const arr = [1, 2, 3, 4, 5];

        // console.log(arr.filter((val, i, ar) => {
        //     return val !== 2;
        // }));
    }
    
    return (
        <>
            <CreateUser 
                username={username}
                email={email}
                onChange={onChange}
                onCreate={onCreate}
            />
            <div>
                {
                    users.map((value, index, array) => {
                        //console.log(value + " : " + index + " : " + array);
                        return <User
                                    key={value.id}  
                                    user={value} 
                                    onToggle={onToggle}
                                    onRemove={onRemove} 
                                />;
                    })
                }
            </div>
        </>
    )
}

export default UserList;