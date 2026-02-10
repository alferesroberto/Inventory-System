import { useState } from "react";
import Login from "./pages/Login";
import Productos from "./pages/Productos";

function App() {

  const [auth, setAuth] = useState(
    !!localStorage.getItem("token")
  );

  if(!auth) return <Login onLogin={()=>setAuth(true)} />

  return <Productos />;
}

export default App;
