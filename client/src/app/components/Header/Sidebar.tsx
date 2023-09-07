import React from "react";
import Image from "next/image";

import profileIcon from "@/app/assets/profile.png";
import studentsIcon from "@/app/assets/student.png";
import coursesIcon from "@/app/assets/book.png";
import teacherIcon from "@/app/assets/teacher.png";
import settingsIcon from "@/app/assets/settings.png";
import logoutIcon from "@/app/assets/logout.png";

const Sidebar = () => {
  return (
    <aside className="fixed h-full w-64 top-0 left-0 bg-gradient-to-br from-primary to-secondary text-white rounded-r-3xl shadow-md rotate-1-right">
      {/* Profile Text/Image */}
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
          <li className="mb-6">
            <a
              href="#"
              className="flex items-center text-gray-300 hover:text-white transition-colors duration-200"
            >
              <Image
                src={studentsIcon}
                alt="Students Icon"
                className="h-8 w-8"
              />
              <span className="ml-3">Students</span>
            </a>
          </li>

          <li className="mb-6">
            <a
              href="#"
              className="flex items-center text-gray-300 hover:text-white transition-colors duration-200"
            >
              <span className="material-icons mr-2">
                <Image
                  src={coursesIcon}
                  alt="Courses Icon"
                  className="h-8 w-8"
                />
              </span>
              Courses
            </a>
          </li>
          <li className="mb-6">
            <a
              href="#"
              className="flex items-center text-gray-300 hover:text-white transition-colors duration-200"
            >
              <span className="material-icons mr-2">
                <Image
                  src={teacherIcon}
                  alt="Courses Icon"
                  className="h-8 w-8"
                />
              </span>
              Teachers
            </a>
          </li>
          <li className="mb-6">
            <a
              href="#"
              className="flex items-center text-gray-300 hover:text-white transition-colors duration-200"
            >
              <span className="material-icons mr-2">
                <Image
                  src={settingsIcon}
                  alt="Courses Icon"
                  className="h-8 w-8"
                />
              </span>
              System Settings
            </a>
          </li>
        </ul>
      </nav>
      <div className="absolute bottom-0 p-4">
        <button className="flex items-center text-gray-300 hover:text-white transition-colors duration-200">
          <Image src={logoutIcon} alt="Courses Icon" className="h-8 w-8" />{" "}
          <span className="mx-2">Sign Out</span>
        </button>
      </div>
    </aside>
  );
};

export default Sidebar;
