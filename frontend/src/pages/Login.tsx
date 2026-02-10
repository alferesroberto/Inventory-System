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
    <div className="min-h-screen flex items-center justify-center bg-slate-100">

      <div className="bg-white w-96 p-8 rounded-xl shadow-xl">

        <h2 className="text-2xl font-bold mb-6 text-center">
          Inventory System
        </h2>

        <input
          className="w-full border rounded px-3 py-2 mb-4"
          placeholder="Usuario"
          onChange={e => setUser(e.target.value)}
        />

        <input
          type="password"
          className="w-full border rounded px-3 py-2 mb-6"
          placeholder="Password"
          onChange={e => setPass(e.target.value)}
        />

        <button
          onClick={login}
          className="w-full bg-blue-600 hover:bg-blue-700 text-white py-2 rounded-lg transition"
        >
          Ingresar
        </button>

      </div>

    </div>
  );
}
