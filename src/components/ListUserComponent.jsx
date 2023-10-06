import React,{useState, useEffect} from 'react'
import UserService from '../service/UserService'
import { Link } from 'react-router-dom'

export const ListUserComponent = () => {
    const [users, setUsers] = useState([])

    useEffect(() => {
      
        UserService.getAllUser().then((response)=>{
            setUsers(response.data);
            console.log(response.data);
        }).catch(error=>{
            console.log(error)
        })

    }, [])
    
  return (
    <div>

    <div className="container">
        <h2 className='text-center my-3'>List Employee</h2>
        <Link to="/createUser" className='btn btn-primary mb-2'>Add User</Link>
        <table className='table table-bordered table-striped'>
        <thead>
        <th>User Id</th>
        <th>User First Name</th>
        <th>User Last Name</th>
        <th>User Email Id</th>
        </thead>
        <tbody>{

                users.map(
                    user=>
                    <tr key={user.id}>
                        <td>{user.id}</td>
                        <td>{user.firstName}</td>
                        <td>{user.lastName}</td>
                        <td>{user.emailId}</td>
                    </tr>
                    
                )

                            }
</tbody>
</table>
    </div>

    </div>
  )
}
