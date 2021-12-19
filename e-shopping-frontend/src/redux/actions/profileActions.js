import {
  USER_DETAILS_REQUEST,
  USER_DETAILS_SUCCESS,
  USER_DETAILS_FAIL,
  USER_DETAILS_RESET,
  CREATE_NEW_USER_REQUEST,
  CREATE_NEW_USER_SUCCESS,
  CREATE_NEW_USER_FAIL,
  CREATE_LOGIN_REQUEST,
  CREATE_LOGIN_SUCCESS,
  CREATE_LOGIN_FAIL
} from "../constants/profileConstants";
import axios from "axios";

/*********************User Profile Data Start***********************************************/

export const getProfileDetails = (email) => async (dispatch) => {
  try {
    dispatch({ type: USER_DETAILS_RESET });
    dispatch({ type: USER_DETAILS_REQUEST });
    const jwtToken = localStorage.getItem("authToken");
    const authHeader = "Bearer " + jwtToken;
    console.log(authHeader)
    const { data } = await axios.get(`/profile/byemail/${email}`, {
      headers: {
        "Authorization": authHeader,
      },
    });
    dispatch({
      type: USER_DETAILS_SUCCESS,
      payload: data,
    });
  } catch (error) {
    dispatch({
      type: USER_DETAILS_FAIL,
      payload:
        error.response && error.response.data.message
          ? error.response.data.message
          : error.message,
    });
  }
};


/*********************Authenticate User & Get Jwt Token Start***********************************************/

export const getJWTTokenByLogin = (email, pass, setIsUserLoggedIn, setError, redirectToHome) => async (dispatch) => {
  try {
    const dataToPost = {
      username: email,
      password: pass
    };

    dispatch({ type: CREATE_LOGIN_REQUEST });

    await axios.post(`/profile/authenticate`, dataToPost).then((response)=>{
      dispatch({
        type: CREATE_LOGIN_SUCCESS,
        payload: response,
      });
      localStorage.setItem("authToken", response.data.jwt)
      localStorage.setItem("email", email)
      dispatch(getProfileDetails(email));
      setIsUserLoggedIn(true);
      setError("");
      alert("You're logged in to E-Shopping Zone!");
      redirectToHome();
    });
  } catch (error) {

    let errorMessage = ""
    if(error.response && error.response.data.message){
      errorMessage = error.response.data.message
    } else {
      errorMessage =error.message
    }

    dispatch({
      type: CREATE_LOGIN_FAIL,
      payload:errorMessage
    });
    if(errorMessage === "Access Denied") 
      setError("Email or password is incorrect!");
    else
      setError(errorMessage);
  }
};


/*********************Authenticate User & Get Jwt Token Start***********************************************/

export const registerUser = (userData, setIsUserLoggedIn, setError, redirectToHome) => async (dispatch) => {
  try {

    dispatch({ type: CREATE_NEW_USER_REQUEST });

    await axios.post(`/profile/customer/add`, userData).then((response)=>{
      dispatch({
        type: CREATE_NEW_USER_SUCCESS,
        payload: response,
      });
      if(response.data.profileId !== null){
        alert("Registration successful!");
        dispatch(getJWTTokenByLogin(userData.email, userData.password, setIsUserLoggedIn, setError, redirectToHome));
      } else {
        setError("User with this email id is already registered!")
      }
    });
  } catch (error) {

    let errorMessage = ""
    if(error.response && error.response.data.message){
      errorMessage = error.response.data.message
    } else {
      errorMessage =error.message
    }

    dispatch({
      type: CREATE_NEW_USER_FAIL,
      payload:errorMessage
    });
    if(errorMessage === "Access Denied") 
      setError("Email or password is incorrect!");
    else
      setError(errorMessage);
  }
};

