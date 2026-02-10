import { useState } from "react";
import Login from "./pages/Login";
import Store from "./pages/Store";

function App() {

  const [auth, setAuth] = useState(
    !!localStorage.getItem("token")
  );

  if (!auth) {
    return <Login onLogin={() => setAuth(true)} />;
  }

  return <Store />;
}

export default App;
