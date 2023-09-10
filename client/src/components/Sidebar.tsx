import React from "react";
import Image from "next/image";

import profileIcon from "@/app/assets/profile.png";
import studentsIcon from "@/app/assets/student.png";
import coursesIcon from "@/app/assets/book.png";
import teacherIcon from "@/app/assets/teacher.png";
import settingsIcon from "@/app/assets/settings.png";
import logoutIcon from "@/app/assets/logout.png";
import { LogoutButton } from "./LogoutButton";

const Sidebar = () => {
  const menuItems = [
    {
      icon: studentsIcon,
      text: "Students",
      onClick: () => {
        console.log("Clicked Students"); // Debugging
        // Handle the button click for Students
        // You can add your navigation logic or actions here
      },
    },
    {
      icon: coursesIcon,
      text: "Courses",
      onClick: () => {
        console.log("Clicked Courses"); // Debugging
        // Handle the button click for Courses
        // You can add your navigation logic or actions here
      },
    },
    {
      icon: teacherIcon,
      text: "Teachers",
      onClick: () => {
        console.log("Clicked Teachers"); // Debugging
        // Handle the button click for Teachers
        // You can add your navigation logic or actions here
      },
    },
    {
      icon: settingsIcon,
      text: "System Settings",
      onClick: () => {
        console.log("Clicked System Settings"); // Debugging
        // Handle the button click for System Settings
        // You can add your navigation logic or actions here
      },
    },
  ];

  return (
    <aside className="fixed inset-y-0 left-0 h-full w-64 bg-gradient-to-br from-primary to-secondary text-white rounded-r-3xl shadow-md z-50">
      <div className="mt-5 p-5 flex items-center">
        <Image
          src={profileIcon}
          alt="Profile Picture"
          className="rounded-full h-14 w-14"
        />
        <div className="ml-3">
          <p className="text-lg font-normal text-slate-200">Username</p>
          <p className="text-sm font-semibold text-gray-400">Administrator</p>
        </div>
      </div>

      <nav className="p-4">
        <ul>
          {menuItems.map((item, index) => (
            <li key={index} className="mb-6">
              <button
                className="flex items-center text-gray-300 hover:text-white transition-colors duration-200"
                onClick={item.onClick}
              >
                <Image
                  src={item.icon}
                  alt={`${item.text} Icon`}
                  className="h-8 w-8"
                />
                <span className="ml-3">{item.text}</span>
              </button>
            </li>
          ))}
        </ul>
      </nav>

      <div className="absolute bottom-0 p-4">
        <span className="flex items-center text-foreground hover:text-white transition-colors duration-200">
          <Image src={logoutIcon} alt="Logout Icon" className="h-8 w-8" />
          <LogoutButton />
        </span>
      </div>
    </aside>
  );
};

export default Sidebar;
