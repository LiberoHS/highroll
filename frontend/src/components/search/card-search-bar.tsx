import React, { useState } from "react";
import {Box, Button, Grid, Heading, TextInput} from "grommet";

export default function CardSearchBar() {
    const [value, setValue] = useState('');

    const updateSearchValue = (text: string) => {
        setValue(text);
    };

    return (
        <Box gap="medium" pad="medium" align="center">
            <Heading level={2}>Search Card</Heading>
            <Grid width="50%" gap="medium">
                <TextInput
                    placeholder="enter your card..."
                    value={value}
                    onChange={event => updateSearchValue(event.target.value)}
                />
                <Grid width="10%">
                    <Button size="small" primary label="search"/>
                </Grid>
            </Grid>
        </Box>
    );
}