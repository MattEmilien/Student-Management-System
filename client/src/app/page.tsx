import Image from "next/image";
import { Metadata } from "next";
import Sidebar from "./components/Header/Sidebar";
import Head from "next/head";

export const metadata: Metadata = {
  title: "Students | Home",
  description: "Welcome to the student management system!",
};

export default function Home() {
  return (
    <main className="">
      <Sidebar />
      <section className="ml-auto mr-auto text-gray-800 flex flex-col justify-center items-center h-screen overflow-hidden relative">
        <h1 className="text-3xl font-bold text-center">
          Welcome to the student management system!
        </h1>
        <p className="text-center">
          This is a student management system. It allows you to add, edit, and
          delete students.
        </p>
      </section>
    </main>
  );
}
