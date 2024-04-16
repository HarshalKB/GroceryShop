import React from "react";
import {useNavigate} from "react-router-dom";

const Navbar = () => {
  const navigate = useNavigate();

  return (
    <nav>
      <h1>Grocery Inventory</h1>
      <div className="go-back">
        <button
          onClick={() => {
            navigate(-1);
          }}
        >
          Go Back
        </button>
      </div>
    </nav>
  );
};

export default Navbar;
