import React, { useState } from "react";
import {Box, Button, Grid, Heading, TextInput} from "grommet";
import {useServices} from "../../state/service-context";

export default function CardSearchBar() {
    const { hearthstoneService } = useServices();
    const [value, setValue] = useState('');

    const searchOnKeyPress = async (event: { key: string }) => {
        if (event.key === "Enter") {
            await searchCard();
        }
    };

    const searchCard = async () => {
        const res = await hearthstoneService.getDiscoverableCards(value, "MAGE");
        console.log(res);
    };

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
                    onKeyDown={event => searchOnKeyPress(event)}
                />
                <Grid width="10%">
                    <Button size="small" primary label="search" onClick={searchCard}/>
                </Grid>
            </Grid>
        </Box>
    );
}