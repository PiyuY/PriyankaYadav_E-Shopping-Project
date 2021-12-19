import { createStore, combineReducers, applyMiddleware } from "redux";
import thunk from "redux-thunk";
import { composeWithDevTools } from "redux-devtools-extension";
import { profileDetailsReducer, loginAndGetJWTReducer, registerUserReducer } from "./redux/reducers/profileReducer";

// we add created reducers here
const reducer = combineReducers({
  profileDetails: profileDetailsReducer,
  regProfileDetails: registerUserReducer,
  authToken: loginAndGetJWTReducer
});

const initialState = {};
const middleware = [thunk];
const store = createStore(
  reducer,
  initialState,
  composeWithDevTools(applyMiddleware(...middleware))
);

export default store;
