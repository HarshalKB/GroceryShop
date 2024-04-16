import {createBrowserRouter} from "react-router-dom";
import Layout from "./Layout";
import Grocery from "./pages/Grocery";
import AddGrocery from "./pages/AddGrocery";
import UpdateGrocery from "./pages/UpdateGrocery";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,
    children: [
      {
        path: "",
        element: <Grocery />,
      },
      {
        path: "/add",
        element: <AddGrocery />,
      },
      {
        path: "/update",
        element: <UpdateGrocery />,
      },
    ],
  },
]);
