"use client";

import Link from "next/link";
import Sidebar from "../components/Sidebar";
import HomeIcon from "@mui/icons-material/HomeOutlined";
import React from "react";
import { Metadata } from "next";
import { Button } from "../components/ui/button";
import { ModeToggle } from "@/components/Theme";
import { AdmissionsCalendar } from "@/components/ui/admissions-calendar";

export const metadata: Metadata = {
  title: "Students | Home",
  description: "Welcome to the student management system!",
};

export default function Home() {
  const [date, setDate] = React.useState<Date | undefined>(new Date());

  return (
    <main className="">
      <Sidebar />
      <section className="ml-auto mr-auto text-gray-800 flex flex-col justify-center items-center h-screen overflow-hidden relative">
        <Link
          href="/"
          className="font-medium text-slate-600 absolute top-8 right-14 hover:text-slate-800"
        >
          <HomeIcon /> Home
        </Link>
        <span className="absolute bottom-10 right-9">
          <ModeToggle />
        </span>
        <span className="absolute border border-gray-300 rounded-lg p-5">
          <AdmissionsCalendar
            mode="single"
            selected={date}
            onSelect={setDate}
          />
        </span>
      </section>
    </main>
  );
}
