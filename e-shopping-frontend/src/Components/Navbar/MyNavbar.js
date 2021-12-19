import { React, useEffect, useState } from "react";
import { Navbar, Nav, NavDropdown } from "react-bootstrap";
// import Form from "react-bootstrap/Form";
// import Button from "react-bootstrap/Button";
// import { Link } from "react-router-dom";
import { LinkContainer } from "react-router-bootstrap";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faShoppingCart } from "@fortawesome/free-solid-svg-icons";
import { faUserCircle } from '@fortawesome/free-solid-svg-icons';
import "./navbar.css";
import { logout } from "../../utils";
import { useHistory } from "react-router-dom";
import { useSelector, useDispatch } from "react-redux";
import { USER_DETAILS_RESET } from "../../redux/constants/profileConstants";

function MyNavbar({ isUserLoggedIn, setIsUserLoggedIn }) {
  const history = useHistory();
  const [name, setName] = useState("User");

  const profileDetailsSelector = useSelector((state) => state.profileDetails);
  const {
    error: user_error,
    loading: user_loading,
    user,
  } = profileDetailsSelector;

  const dispatch = useDispatch();

  const handleLogout = () => {
    if (window.confirm("Do you want to log out?")) {
      dispatch({ type: USER_DETAILS_RESET });
      localStorage.clear();
      setIsUserLoggedIn(false);
      history.push("/home");
      alert("You're successfully logged out!");
    }
  };

  useEffect(() => {
    if (isUserLoggedIn && user) {
      setName(user.fullName);
    }
  }, [isUserLoggedIn, user]);

  return (
    <Navbar collapseOnSelect expand="lg" bg="dark" variant="dark" sticky="top">
      <LinkContainer to={"/home"}>
        <Navbar.Brand>E-ShoppingZone</Navbar.Brand>
      </LinkContainer>
      <Navbar.Toggle aria-controls="responsive-navbar-nav" />
      <Navbar.Collapse id="responsive-navbar-nav">
        <Nav className="mr-auto">
          {/* <Form className="d-flex">
            <Form.Control
              type="search"
              placeholder="Search"
              className="mr-2"
              aria-label="Search"
            />
            <Button variant="outline-success">Search</Button>
          </Form> */}
        </Nav>
        <Nav>
          <LinkContainer to={"/home"}>
            <Nav.Link>Home</Nav.Link>
          </LinkContainer>
          <LinkContainer to={"/browse-products"}>
            <Nav.Link>Products</Nav.Link>
          </LinkContainer>
          {isUserLoggedIn && user !== undefined ? (
            <>

              <NavDropdown
                title={
                  <>
                  <FontAwesomeIcon className="fa-lg" icon={faUserCircle} />
                  &nbsp;Hi, {name?.split(" ")[0]}
                  </>
              }
                id="basic-nav-dropdown"
              >
                <LinkContainer to={"/my-account"}>
                <NavDropdown.Item>My Account</NavDropdown.Item>
                </LinkContainer>
                <LinkContainer to={"/cart"}><NavDropdown.Item>My Cart</NavDropdown.Item></LinkContainer>
                <LinkContainer to={"/orders"}><NavDropdown.Item>My Orders</NavDropdown.Item></LinkContainer>
                <NavDropdown.Divider />
                <NavDropdown.Item onClick={handleLogout}>
                  Logout
                </NavDropdown.Item>
              </NavDropdown>
              <LinkContainer to={"/cart"}>
                <Nav.Link>
                  <FontAwesomeIcon className="fa-lg" icon={faShoppingCart} />
                  &nbsp;Cart
                </Nav.Link>
              </LinkContainer>
            </>
          ) : (
            <>
              <LinkContainer to={"/user-login"}>
                <Nav.Link id="login-link">Login</Nav.Link>
              </LinkContainer>
              <LinkContainer to={"/user-registration"}>
                <Nav.Link id="signUp-link">Sign Up</Nav.Link>
              </LinkContainer>
            </>
          )}

          {/* <Link to={"/home"}>Home</Link>
            <Link to={"/projects"}>Projects</Link>
            <Link to={"/services"}>Services</Link>
            <Link to={"/contacts"}>Contacts</Link> */}
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
}

export default MyNavbar;
