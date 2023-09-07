// tailwind.config.js

import { Config } from "tailwindcss";

const config: Config = {
  content: [
    "./src/pages/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/components/**/*.{js,ts,jsx,tsx,mdx}",
    "./src/app/**/*.{js,ts,jsx,tsx,mdx}",
  ],
  theme: {
    extend: {
      fontFamily: {
        lato: ["Lato", "sans"],
        "roboto-slab": ["Roboto Slab", "serif"],
      },
      backgroundImage: {
        "gradient-radial": "radial-gradient(var(--tw-gradient-stops))",
        "gradient-conic":
          "conic-gradient(from 180deg at 50% 50%, var(--tw-gradient-stops))",
      },
      gradientColorStops: {
        primary: "var(--primary-gradient-color, #575A5C)",
        secondary: "var(--secondary-gradient-color, #2E3439)",
      },
      opacity: {
        "20": "0.2",
        "40": "0.4",
      },
      rotate: {
        "-right": "-10deg", 
      },
    },
  },
  plugins: [],
};

export default config;
