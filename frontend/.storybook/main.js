import {withGrommet} from "storybook-addon-grommet";
import { addDecorator } from '@storybook/react';
import { grommet, dark } from 'grommet';
import { black, light, materialdark, materiallight, metro } from 'grommet-controls';

module.exports = {
  "stories": [
    "../src/**/*.stories.mdx",
    "../src/**/*.stories.@(js|jsx|ts|tsx)"
  ],
  "addons": [
    "@storybook/addon-links",
    "@storybook/addon-essentials",
    "@storybook/preset-create-react-app"
  ],
  typescript: {
    reactDocgen: 'none',
  }
};

addDecorator(withGrommet({
      theme: 'grommet',
      themes: {
        grommet,
        dark,
        black,
        light,
        materialdark,
        materiallight,
        metro,
      },
      boxProps: {
        align: 'start',
      },
      grommetProps: {
        full: true,
      }
    }
));