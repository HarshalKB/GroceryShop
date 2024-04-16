import React, {useState, useEffect} from "react";
import {useNavigate} from "react-router-dom";
import {addGrocery, listSources} from "../service/GroceryService";

const AddGrocery = () => {
  const [grocery, setGrocery] = useState({
    id: "",
    name: "",
    type: "",
    source: "",
    costPerItem: "",
    itemsAvailable: "",
  });

  const navigate = useNavigate();

  const [states, setStates] = useState([]);
  useEffect(() => {
    listSources()
      .then((res) => setStates(res.data))
      .catch((error) => console.log(error));
  }, []);

  function validateForm() {
    let valid = true;
    const groceryDto = {...grocery};
    if (
      !groceryDto.id.trim() ||
      !groceryDto.name.trim() ||
      !groceryDto.type.trim() ||
      !groceryDto.source.trim() ||
      !groceryDto.costPerItem.trim() ||
      !groceryDto.itemsAvailable.trim()
    ) {
      valid = false;
    }
    return valid;
  }

  function handleSubmit(e) {
    e.preventDefault();
    if (validateForm()) {
      addGrocery(grocery)
        .then((res) => console.log(res.data))
        .catch((error) => console.log(error));
      navigate("/");
    } else {
      alert("All inputs are required.");
    }
  }

  return (
    <div className="add-grocery">
      <h2>Add Grocery Item</h2>
      <form>
        <div className="entry">
          <label htmlFor="id">Enter Grocery Id : </label>
          <input
            type="text"
            id="id"
            placeholder="Grocery Id"
            value={grocery.id}
            onChange={(e) => setGrocery({...grocery, id: e.target.value})}
          />
        </div>
        <div className="entry">
          <label htmlFor="name">Enter Grocery Name : </label>
          <input
            type="text"
            id="name"
            placeholder="Name"
            value={grocery.name}
            onChange={(e) => setGrocery({...grocery, name: e.target.value})}
          />
        </div>
        <div className="entry">
          <label htmlFor="type">Enter Grocery Type : </label>
          <input
            type="text"
            id="type"
            placeholder="Grocery Type"
            value={grocery.type}
            onChange={(e) => setGrocery({...grocery, type: e.target.value})}
          />
        </div>
        <div className="entry">
          <label className="dropdown" htmlFor="source">
            Enter Grocery Source :{" "}
          </label>
          <select
            name="source"
            id="source"
            onChange={(e) => setGrocery({...grocery, source: e.target.value})}
          >
            {states.map((state) => (
              <option key={state.id} value={state.source}>
                {state.source}
              </option>
            ))}
          </select>
        </div>
        <div className="entry">
          <label htmlFor="quantity">Enter Grocery Quantity : </label>
          <input
            type="text"
            id="quantity"
            placeholder="Quantity"
            value={grocery.itemsAvailable}
            onChange={(e) =>
              setGrocery({...grocery, itemsAvailable: e.target.value})
            }
          />
        </div>
        <div className="entry">
          <label htmlFor="cost-per-item">Enter the Cost per Item : </label>
          <input
            type="text"
            id="cost-per-item"
            placeholder="Grocery Cost"
            value={grocery.costPerItem}
            onChange={(e) =>
              setGrocery({...grocery, costPerItem: e.target.value})
            }
          />
        </div>
        <div className="entry">
          <button className="submit" onClick={(e) => handleSubmit(e)}>
            Submit
          </button>
        </div>
      </form>
    </div>
  );
};

export default AddGrocery;
