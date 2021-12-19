import { React, useEffect } from "react";
import { useSelector } from "react-redux";
import "../assets/css/style.css";
import styled from "styled-components";
import Carousel from "react-bootstrap/Carousel";

import SignUpImage from "../assets/images/SignUpImg.png";
import LoginImage from "../assets/images/loginImg.png";
import { Button } from "react-bootstrap";
import { LinkContainer } from "react-router-bootstrap";
// import { LinkContainer } from "react-router-bootstrap";

function Home({ isUserLoggedIn }) {
  const profileDetailsSelector = useSelector((state) => state.profileDetails);
  const {
    error: user_error,
    loading: user_loading,
    user,
  } = profileDetailsSelector;

  return (
    <HomeMain className="pages container">
      <MyBanner>
        <BannerSideText className="col-md-6">
          <h1>Explore E-ShoppingZone</h1>
          <span>
            <h5>We have wide range varieties of products for you</h5>
            <h5>Click on 'Shop Now' and start your shopping journey with us.</h5>
          </span>
          <LinkContainer to={"/browse-products"}>
            <Button>Shop Now</Button>
          </LinkContainer>
        </BannerSideText>
        <BannerSlider className="col-md-6">
          <Carousel fade>
            <Carousel.Item interval={3500}>
              <img
                className="d-block w-100"
                src={SignUpImage}
                alt="First slide"
              />
            </Carousel.Item>
            <Carousel.Item interval={3500}>
              <img
                className="d-block w-100"
                src={LoginImage}
                alt="Second slide"
              />
            </Carousel.Item>
            <Carousel.Item interval={3500}>
              <img
                className="d-block w-100"
                src={SignUpImage}
                alt="Third slide"
              />
            </Carousel.Item>
          </Carousel>
        </BannerSlider>
      </MyBanner>
    </HomeMain>
  );
}

export default Home;

const HomeMain = styled.div``;
const MyBanner = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  /* flex-direction: row; */
`;

const BannerSideText = styled.div`
  h1{
    color: rgb(255, 120, 0);
  }
  span {
    display: block;
    margin-top: 25px;
  }
  .btn {
    width: 180px;
    margin-top: 15px;
    background-color: rgb(255, 165, 0);
    border-color: rgb(255, 165, 0);
    border-radius: 25px;
    font-size: 1.2rem;
    color: #000000;
    :hover {
      background-color: rgb(255, 165, 0);
      box-shadow: none !important;
    }
  }
`;
const BannerSlider = styled.div`
  /* display: flex;
align-items: center;
justify-content: center;
flex-direction: row; */
  height: 500px;
  overflow: hidden;

  .carousel-control-next,
  .carousel-control-prev,
  .carousel-indicators {
    display: none !important;
  }

  img {
    height: 500px;
    width: auto;
  }
`;
