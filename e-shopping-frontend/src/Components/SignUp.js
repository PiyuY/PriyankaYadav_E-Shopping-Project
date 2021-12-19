import {React, useRef, useState} from "react";
import Form from "react-bootstrap/Form";
import InputGroup from "react-bootstrap/InputGroup";
import FormControl from "react-bootstrap/FormControl";
import Button from "react-bootstrap/Button";
/***********************CSS & IMAGES (Assets)***************************/
import styled from "styled-components";
import "../assets/css/style.css";
import SignUpImage from "../assets/images/SignUpImg.png";
import { LinkContainer } from "react-router-bootstrap";
import { isEmail, isMobileNumber } from "../utils";
import { useHistory } from "react-router-dom";
import { useDispatch, useSelector} from "react-redux";
import { registerUser } from "../redux/actions/profileActions";


function SignUp({isUserLoggedIn, setIsUserLoggedIn}) {
  const fNameRef = useRef("");
  const lNameRef = useRef("");
  const emailRef = useRef("");
  const mobileNoRef = useRef("");
  const passRef = useRef("");
  const confPassRef = useRef("");

  const [error, setError] = useState("")

  const dispatch = useDispatch();

  const history = useHistory();
  const redirectToHome = () => {
    history.push("/home");
  };

  const regProfileDetailsSelector = useSelector((state) => state.regProfileDetails);
  const { error: user_error, loading: user_loading, user } = regProfileDetailsSelector;


  const register = (e) => {
    e.preventDefault();
    const fName = fNameRef.current.value;
    const lName = lNameRef.current.value;
    const email = emailRef.current.value;
    const mobileNo = mobileNoRef.current.value;
    const pass = passRef.current.value;
    const confPass = confPassRef.current.value;

    if(fName === "" || lName === "" || email === "" || mobileNo === "" || pass === "" || confPass === ""){
      setError(`**All fields are required!`)
      return;
    }

    if(!isMobileNumber(mobileNo)){
      setError(`**Enter valid mobile no.!`)
      return;
    }

    if(!isEmail(email)){
      setError(`**Enter valid email id!`)
      return;
    }

    if(pass.length < 8) {
      setError(`**Password should atleast be 8 character long!`)
      return;
    }

    if(pass !== confPass){
      setError(`**Passwords are not matching!`)
      return;
    }

    const userData = {
      fullName: fName + " " + lName,
      mobileNumber: mobileNo,
      email: email,
      password: pass
    }
    dispatch(registerUser(userData, setIsUserLoggedIn, setError, redirectToHome));
  }

  return (
      <SignUpMain className="pages">
    <SignUpTitle><h3>Create your account and join us</h3></SignUpTitle>
    <SignUpContainer>
        <SignUpImg className="col-md-4">
        <img id="SignUp-img" src={SignUpImage} alt="Sign-Up Img" />
      </SignUpImg>
      <SignUpForm className="col-md-4">
        <Form>
        <LoginError>{error}</LoginError>
          <InputGroup className="mb-3">
            <InputGroup.Text>First &amp; last name</InputGroup.Text>
            <FormControl ref={fNameRef} aria-label="First name" placeholder="First Name"/>
            <FormControl ref={lNameRef} aria-label="Last name" placeholder="Last Name"/>
          </InputGroup>
        
          <InputGroup className="mb-3">
            <InputGroup.Text>+91</InputGroup.Text>
            <FormControl ref={mobileNoRef} aria-label="MobileNo" type="number" placeholder="Enter Mobile No." maxLength={10}/>
          </InputGroup>
       
          <InputGroup className="mb-3">
            <InputGroup.Text>Email</InputGroup.Text>
            <FormControl ref={emailRef} aria-label="Email" type="email" placeholder="Enter Email"/>
          </InputGroup>
        
          <InputGroup className="mb-3">
            <InputGroup.Text>Password</InputGroup.Text>
            <FormControl ref={passRef} aria-label="Password" type="password" placeholder="Enter Password"/>
          </InputGroup>

          <InputGroup className="mb-3">
            <InputGroup.Text>Confirm Password</InputGroup.Text>
            <FormControl ref={confPassRef} aria-label="Confirm Password" type="password" placeholder="Confirm Password"/>
          </InputGroup>
          
          
          {/* <a href="#" style={{ fontSize: "0.7rem" }}>
            Forgot Password
          </a> */}

          <Button type="button" onClick={register}>
            {
              user_loading ? 
                <>Signing up...</>
                : <>Sign up</>
            }
          </Button>
          <LinkContainer  to="/user-login">
          <LoginLink>Already have account? Login here</LoginLink>
          </LinkContainer>
         
        </Form>
      </SignUpForm>
      
    </SignUpContainer>
    </SignUpMain>
  );
}

export default SignUp;


//********************************Styled Components*************************************************************
const SignUpMain = styled.div``;
const SignUpTitle = styled.div`
width: fit-content;
margin: 0 auto;
text-align: start;`;

const SignUpContainer = styled.div`
    display: flex;
  align-items: center;
  justify-content: center;
  flex-direction: row;
  flex-wrap: wrap !important;
`;
const SignUpForm = styled.div`
border-left: 2px solid rgb(255, 165, 0);
  padding: 4rem 1rem 4rem 4rem !important;
  Form {
    align-items: flex-start !important;

    .input-group-text {
        background-color: rgb(217 230 255) !important;
    }
    a{
      display:inline-block;
    text-align: center !important;
    width: 100%
  }
  }
 
  .btn {
    margin-top: 20px;
    border-radius: 25rem;
    width: 100%;
    background-color: rgb(255, 165, 0);
    border: 1px solid rgb(255, 165, 0);
    transition: 0.5s;
    :hover {
        background-color: rgb(255, 100, 0);
    }
  }
`;

const LoginError = styled.h6`
  color: red;
`;

const LoginLink = styled.a`
  display: inline-block;
  margin-top: 5px;
  text-align: center !important;
  width: 100%;
`;

const SignUpImg = styled.div`
margin-right: 2rem;
  padding: 1rem;

img {
  height: auto;
  width: 100%;
}
`;



