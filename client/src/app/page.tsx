import Image from "next/image";
import Link from "next/link";
import { Metadata } from "next";
import Sidebar from "./components/Header/Sidebar";
import HomeIcon from "@mui/icons-material/HomeOutlined";
import { Button } from "../components/ui/button";
import { Alert, AlertDescription, AlertTitle } from "@/components/ui/alert"

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
        <br />
        <Button>Click here to get started!</Button>
        <Link
          href="/"
          className="font-medium text-slate-600 absolute top-8 right-14 hover:text-white"
        >
          <HomeIcon /> Home
        </Link>
        <Alert>
          <Terminal className="h-4 w-4" />
          <AlertTitle>Heads up!</AlertTitle>
          <AlertDescription>
            You can add components and dependencies to your app using the cli.
          </AlertDescription>
        </Alert>
      </section>
    </main>
  );
}
