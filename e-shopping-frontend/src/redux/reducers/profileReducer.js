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

export const profileDetailsReducer = (state = { user: {}}, action) => {
    switch (action.type) {
        case USER_DETAILS_REQUEST:
          return { loading: true, ...state };
    
        case USER_DETAILS_SUCCESS:
          return { loading: false, user: action.payload };
    
        case USER_DETAILS_FAIL:
          return { loading: false, error: action.payload };
          
        case USER_DETAILS_RESET:
          return { loading: true, user: {} };
        
        case CREATE_NEW_USER_REQUEST:
        return { loading: true, ...state };
    
        case CREATE_NEW_USER_SUCCESS:
        return { loading: false, user: action.payload };
    
        case CREATE_NEW_USER_FAIL:
        return { loading: false, error: action.payload };

        default:
          return state;
      }
}

export const loginAndGetJWTReducer = (state = { jwt: {}}, action) => {
  switch (action.type) {
      case CREATE_LOGIN_REQUEST:
        return { loading: true, ...state };
  
      case CREATE_LOGIN_SUCCESS:
        return { loading: false, jwt: action.payload };
  
      case CREATE_LOGIN_FAIL:
        return { loading: false, error: action.payload }; 

      default:
        return state;
    }
}

export const registerUserReducer = (state = { user: {}}, action) => {
  switch (action.type) {
      case CREATE_NEW_USER_REQUEST:
        return { loading: true, ...state };
  
      case CREATE_NEW_USER_SUCCESS:
        return { loading: false, user: action.payload };
  
      case CREATE_NEW_USER_FAIL:
        return { loading: false, error: action.payload }; 

      default:
        return state;
    }
}