import { React, useRef, useState } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import styled from "styled-components";
import { useDispatch, useSelector } from "react-redux";
import { useHistory } from "react-router-dom";
import { getJWTTokenByLogin } from "../redux/actions/profileActions";
/***********************CSS & IMAGES (Assets)***************************/
import "../assets/css/style.css";
import loginImage from "../assets/images/loginImg.png";
import { isEmail } from "../utils";
import { LinkContainer } from "react-router-bootstrap";
/***********************CSS & IMAGES (Assets)***************************/

function LoginPage({ isUserLoggedIn, setIsUserLoggedIn }) {
  const emailRef = useRef();
  const passRef = useRef();

  const [error, setError] = useState("");

  const dispatch = useDispatch();

  const authTokenSelector = useSelector((state) => state.authToken);
  const { error: auth_error, loading: auth_loading, jwt } = authTokenSelector;

  const history = useHistory();
  const redirectToHome = () => {
    history.push("/home");
  };

  const login = (e) => {
    e.preventDefault();
    const email = emailRef.current.value;
    const pass = passRef.current.value;

    // validation for login form
    if (!isEmail(email)) {
      setError("**Enter valid email id!");
      return;
    }

    if (email === "" || pass === "") {
      setError("**Both fields are required!");
      return;
    }
    // calling authentication api with email & pass to get token
    dispatch(
      getJWTTokenByLogin(
        email,
        pass,
        setIsUserLoggedIn,
        setError,
        redirectToHome
      )
    );
  };

  // *********************************************************************************************************
  return (
    <LoginMain className="pages">
      <LoginTitle>
        <h3>Login, to explore your account</h3>
      </LoginTitle>
      <br />
      <LoginFormContainer>
        <LoginForm className="col-md-3">
          <Form>
            <LoginError>{error}</LoginError>
            <Form.Group controlId="formBasicEmail">
              {/* <Form.Label>Email address</Form.Label> */}
              <Form.Control
                ref={emailRef}
                type="email"
                placeholder="Enter email"
              />
            </Form.Group>
            <br />
            <Form.Group controlId="formBasicPassword">
              {/* <Form.Label>Password</Form.Label> */}
              <Form.Control
                ref={passRef}
                type="password"
                placeholder="Password"
              />
            </Form.Group>

            <LinkContainer to={"/forgot-password"}>
              <ForgotPassword>Forgot Password</ForgotPassword>
            </LinkContainer>

            <Button variant="primary" type="button" onClick={login}>
              {auth_loading ? <>Logging in...</> : <>Login</>}
            </Button>
            <LinkContainer to="/user-registration">
              <SignUpLink>Don't have account? Create account</SignUpLink>
            </LinkContainer>
          </Form>
        </LoginForm>
        <LoginImg className="col-md-3">
          <img src={loginImage} alt="Login Img" />
        </LoginImg>
      </LoginFormContainer>
    </LoginMain>
  );
}

export default LoginPage;

//********************************Styled Components*************************************************************
const LoginMain = styled.div``;

const LoginTitle = styled.div`
  width: fit-content;
  margin: 0 auto;
  text-align: start;
`;

const LoginFormContainer = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: row;
  flex-wrap: wrap-reverse !important;
`;

const LoginForm = styled.div`
  border-right: 2px solid rgb(255, 165, 0);
  padding: 4rem 4rem 4rem 1rem !important;
  Form {
    align-items: flex-start !important;
  }
  .form-control {
    border-style: none;
    border-radius: 0px;
    border-bottom: 1px solid grey;
  }
  .btn {
    margin-top: 20px;
    border-radius: 25rem;
    width: 100%;
  }
`;
const SignUpLink = styled.a`
  display: inline-block;
  margin-top: 5px;
  text-align: center !important;
  width: 100%;
`;

const ForgotPassword = styled.a`
  font-size: 0.9rem;
`;

const LoginError = styled.h6`
  color: red;
`;

const LoginImg = styled.div`
  margin-left: 2rem;
  padding: 1rem;
  img {
    height: auto;
    width: 100%;
  }
`;
