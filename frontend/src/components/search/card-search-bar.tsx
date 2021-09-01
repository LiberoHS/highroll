import React, { useState } from "react";
import {Box, Button, Grid, Heading, TextInput} from "grommet";
import {useServices} from "../../state/service-context";
import {useCurrentClasses} from "../../state/chosen-deck-context";
import {useCardResults} from "../../state/card-results-context";
import {DiscoverResults} from "../../model/hearthstone-card";

export default function CardSearchBar() {
    const { hearthstoneService } = useServices();
    const [, classActions] = useCurrentClasses();
    const [, searchResultActions] = useCardResults();
    const [value, setValue] = useState('');

    const searchOnKeyPress = async (event: { key: string }) => {
        if (event.key === "Enter") {
            await searchCard();
        }
    };

    const searchCard = async () => {
        const classKey = classActions.getClassKey();
        const response: DiscoverResults = await hearthstoneService.getDiscoverableCards(value, classKey);
        if (response == undefined) {
            searchResultActions.cannotFindResult(true);
        } else {
            searchResultActions.cannotFindResult(false);
            searchResultActions.updateResults(response.results);
        }
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