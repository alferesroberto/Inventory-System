import { useState } from "react";
import api from "../api/axios";

export default function Login({ onLogin }: any) {

  const [user, setUser] = useState("");
  const [pass, setPass] = useState("");

  const login = async () => {
    const res = await api.post(
      `/auth/login?username=${user}&password=${pass}`
    );
    localStorage.setItem("token", res.data.token);
    onLogin();
  };

  return (
    <div>
      <h2>Login</h2>

      <input placeholder="User" onChange={e=>setUser(e.target.value)} />
      <input type="password" placeholder="Password" onChange={e=>setPass(e.target.value)} />

      <button onClick={login}>Login</button>
    </div>
  );
}
