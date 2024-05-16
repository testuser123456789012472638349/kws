import { useRef, useState } from "react";
import User from "./User";
import CreateUser from "./CreateUser";

// function User({user}) {
//     return (
//         <div>
//             <b>{user.username}</b> <span>({user.email})</span>
//         </div>
//     );
// }

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

    const [users, setUsers] = useState(temp);

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
            email: email
        };

        // console.log(users);

        // users.push(user);
        // console.log(users);
        setUsers(users.slice().concat(user));
        setUsers([
            ...users,
            user
        ]);

        setInputs({
            username: '',
            email: ''
        });

        nextId.current += 1;
    }
    // console.log(nextId.current + 1);

    const onToggle = id => {
        // console.log(id);
        // setInputs(users.map((val, i, arr) => (
        //     val.id === id ? {
        //         ...val,
        //         active: !val.active
        //     } : val
        // )));
        // console.log(users);

        // const nowIndex = id - 1;
        // const arr = users.slice();
        // const user = arr[nowIndex];
        // user.active = !arr[nowIndex].active;
        // arr[nowIndex] = user;
        // setUsers(arr);

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
        //     console.log(val, i, ar);
        //     return val !== 2;
        // }));
    };

    return (
        <div>
            {/* <div>
                {users.map(user => (<User user={user} key={user.id} />))}
            </div>
            <div>{array.map(item => <div key={item.id}>{item.text}</div>)};</div> */}
            {/* <div>
                <User user={users[0]} />
                <b>{users[0].username}</b> <span>({users[0].email})</span>
            </div>
            <div>
                <User user={users[1]} />
                <b>{users[1].username}</b> <span>({users[1].email})</span>
            </div>
            <div>
                <User user={users[2]} />
                <b>{users[2].username}</b> <span>({users[2].email})</span>
            </div> */}
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
                            // console.log(value + " : " + index + " : " + array);
                            return <User user={value} key={value.id} onRemove={onRemove} onToggle={onToggle}/>; 
                        })
                    }
                    {/* <User user={users[0]} />
                    <User user={users[1]} />
                    <User user={users[2]} />
                    <User user={users[3]} /> */}
                </div>
            </>
        </div>
    );
}

export default UserList;