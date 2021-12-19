import React from 'react'
import "./toggleBtn.css";

function MyToggleBtn({toggled, setToggled}) {
    const toggleState = () =>{
        setToggled(!toggled);
    }
    return (
        <label className="switch">
            <input type="checkbox" checked={toggled} onClick={toggleState}/>
            <span className="slider round"></span>
        </label>
    )
}

export default MyToggleBtn
