"use client";
import * as React from "react";
import { ChevronLeft, ChevronRight } from "lucide-react";
import { DayPicker } from "react-day-picker";
import { cn } from "@/lib/utils";
import { buttonVariants } from "@/components/ui/button";
import { Poppins } from "next/font/google";
import Image from "next/image";
import ClockImage from "../../app/assets/clock.png";

const poppins = Poppins({
  weight: "500",
  subsets: ["latin"],
});

const current = new Date();
const date = `${current.getDate()}/${
  current.getMonth() + 1
}/${current.getFullYear()}`;

export type CalendarProps = React.ComponentProps<typeof DayPicker>;

function AdmissionsCalendar({
  className,
  classNames,
  showOutsideDays = true,
  ...props
}: CalendarProps) {
  return (
    <>
      <h1 className={poppins.className}>Admissions Calendar</h1>
      <br />
      <div className="flex flex-row gap-10">
        <Image src={ClockImage} alt="Clock" width={50} height={50} />{" "}
        <span className="absolute right-[130px] my-3">
          <p>{date}</p>
        </span>
      </div>
      <br />

      <DayPicker
        showOutsideDays={showOutsideDays}
        className={cn("p-3", className)}
        classNames={{
          months:
            "flex flex-col sm:flex-row space-y-4 sm:space-x-4 sm:space-y-0",
          month: "space-y-4",
          caption: "flex justify-center pt-1 relative items-center",
          caption_label: "text-sm font-medium",
          nav: "space-x-1 flex items-center",
          nav_button: cn(
            buttonVariants({ variant: "outline" }),
            "h-7 w-7 bg-transparent p-0 opacity-50 hover:opacity-100"
          ),
          nav_button_previous: "absolute left-1",
          nav_button_next: "absolute right-1",
          table: "w-full border-collapse space-y-1",
          head_row: "flex",
          head_cell:
            "text-muted-foreground rounded-md w-9 font-normal text-[0.8rem]",
          row: "flex w-full mt-2",
          cell: "text-center text-sm p-0 relative [&:has([aria-selected])]:bg-accent first:[&:has([aria-selected])]:rounded-l-md last:[&:has([aria-selected])]:rounded-r-md focus-within:relative focus-within:z-20",
          day: cn(
            buttonVariants({ variant: "ghost" }),
            "h-9 w-9 p-0 font-normal aria-selected:opacity-100"
          ),
          day_selected:
            "bg-teal-400 text-primary-foreground hover:bg-primary hover:text-primary-foreground focus:bg-primary focus:text-primary-foreground border-b-2 border-accent-400 rounded-full",
          day_today:
            "bg-accent text-accent-foreground bg-red-500/80 border-b-2 border-accent-400 rounded-full",
          day_outside: "text-muted-foreground opacity-50",
          day_disabled: "text-muted-foreground opacity-50",
          day_range_middle:
            "aria-selected:bg-accent aria-selected:text-accent-foreground",
          day_hidden: "invisible",
          ...classNames,
        }}
        components={{
          IconLeft: ({ ...props }) => <ChevronLeft className="h-4 w-4" />,
          IconRight: ({ ...props }) => <ChevronRight className="h-4 w-4" />,
        }}
        {...props}
      />
    </>
  );
}
AdmissionsCalendar.displayName = "Calendar";

export { AdmissionsCalendar };
