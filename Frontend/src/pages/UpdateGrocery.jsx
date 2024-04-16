import React, {useState, useEffect} from "react";
import {useLocation, useNavigate} from "react-router-dom";
import {updateGrocery, listSources} from "../service/GroceryService";

const UpdateGrocery = () => {
  const location = useLocation();
  const [grocery, setGrocery] = useState({...location.state});
  const navigate = useNavigate();

  const [states, setStates] = useState([]);
  useEffect(() => {
    listSources()
      .then((res) => setStates(res.data))
      .catch((error) => console.log(error));
  }, []);

  function handleUpdate(e) {
    e.preventDefault();
    updateGrocery(grocery.id, grocery)
      .then((res) => {
        console.log(res.data);
        navigate("/");
      })
      .catch((error) => console.log(error));
  }

  return (
    <div className="update">
      <h2>Update Grocery</h2>
      <form>
        <div className="for-id">
          <p>
            For Grocery Id : <span>{grocery.id}</span>
          </p>
        </div>
        <div className="entry">
          <label htmlFor="name">Update Grocery Name : </label>
          <input
            type="text"
            id="name"
            placeholder="Name"
            value={grocery.name}
            onChange={(e) => setGrocery({...grocery, name: e.target.value})}
          />
        </div>
        <div className="entry">
          <label htmlFor="type">Update Grocery Type : </label>
          <input
            type="text"
            id="type"
            placeholder="Grocery Type"
            value={grocery.type}
            onChange={(e) => setGrocery({...grocery, type: e.target.value})}
          />
        </div>
        <div className="entry">
          <label htmlFor="source">Update Grocery Source : </label>
          <select
            name="source"
            id="source"
            onChange={(e) => setGrocery({...grocery, source: e.target.value})}
          >
            {states.map((state) => (
              <option
                key={state.id}
                value={state.source}
                selected={state.source == grocery.source}
              >
                {state.source}
              </option>
            ))}
          </select>
        </div>
        <div className="entry">
          <label htmlFor="quantity">Update Grocery Quantity : </label>
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
          <label htmlFor="cost-per-item">Update the Cost per Item : </label>
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
          <button className="submit" onClick={(e) => handleUpdate(e)}>
            Update
          </button>
        </div>
      </form>
    </div>
  );
};

export default UpdateGrocery;
