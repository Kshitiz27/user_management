import './App.css';
import { ListUserComponent } from './components/ListUserComponent';
import { HeaderComp } from './components/HeaderComp';
import {Routes,Route} from 'react-router-dom';
import { AddUser } from './components/AddUser';

function App() {
  return (
    <div className="App">
      <HeaderComp/>
      <div className='container'>
      <Routes>
        <Route exact path='/' Component={ListUserComponent}/>
        <Route exact path='/getUsers' Component={ListUserComponent}/>
        <Route exact path='/createUser' Component={AddUser}></Route>
      </Routes>
      </div>
    </div>
  );
}

export default App;
