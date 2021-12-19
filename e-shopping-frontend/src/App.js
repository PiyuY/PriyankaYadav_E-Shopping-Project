import './App.css';
import MyNavbar from "./Components/Navbar/MyNavbar";
import MyFooter from "./Components/Footer/Footer"
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";

/***********************(All components)***************************/
import Home from "./Components/Home";
import LoginPage from "./Components/LoginPage";
import SignUp from "./Components/SignUp";
import Cart from "./Components/Pages/Cart";
import { useState, useEffect } from 'react';
import { getProfileDetails } from './redux/actions/profileActions';
import { useDispatch } from 'react-redux';

function App() {
  const [isUserLoggedIn, setIsUserLoggedIn] = useState(false);

  const dispatch = useDispatch();
  useEffect(() => {
    if(localStorage.getItem("authToken") && localStorage.getItem("email")) {
      setIsUserLoggedIn(true);
      dispatch(getProfileDetails(localStorage.getItem("email")))
    }
  }, [])

  return (
    <Router>
      <div className="App">
        <MyNavbar isUserLoggedIn={isUserLoggedIn} setIsUserLoggedIn={setIsUserLoggedIn}></MyNavbar>
        <Switch>
          
      {/*********************************Routing Pages Start***************************************/}
          
        <Route path="/home" exact>
          <Home isUserLoggedIn={isUserLoggedIn}/>
        </Route>
          {/* <Route path="/" component={Home} exact /> */}
          <Route path="/" exact>
            <Home isUserLoggedIn={isUserLoggedIn}/>
          </Route>
          <Route path="/user-login">
            <LoginPage isUserLoggedIn={isUserLoggedIn} setIsUserLoggedIn={setIsUserLoggedIn}/>
          </Route>
          <Route path="/user-registration">
            <SignUp isUserLoggedIn={isUserLoggedIn} setIsUserLoggedIn={setIsUserLoggedIn}/>
          </Route>
          <Route path="/cart">
            <Cart isUserLoggedIn={isUserLoggedIn} setIsUserLoggedIn={setIsUserLoggedIn}/>
          </Route>

        {/*********************************Routing pages End***************************************/}
          
        </Switch>
        <MyFooter></MyFooter>
      </div>
    </Router>
  );
}

export default App;
