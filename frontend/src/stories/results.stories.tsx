import React from 'react';
import {storiesOf} from "@storybook/react";
import {Box, Grid, Grommet, List} from "grommet";
import CardSearchResults from "../components/results/card-search-results";
import {ServiceProvider} from "../state/service-context";
import {useCardResults} from "../state/card-results-context";

storiesOf('Results', module)
    .add('Search results', () => {
        const card = {
            "id": "57217",
            "name": "Apexis Blast",
            "image": "https://d15f34w2p8l1cc.cloudfront.net/hearthstone/b25ab0491d1fa3672991edf4bf853b0c38460aa57fc5d5ea1c34d7271a79f63a.png"
        };

        return (
            <ServiceProvider>
                <Grommet>
                    <Grid
                        rows={['xxsmall', 'xsmall']}
                        columns={['small', 'medium']}
                        gap="small"
                        areas={[
                            { name: 'list', start: [0, 1], end: [0, 1] },
                            { name: 'viewer', start: [1, 1], end: [1, 1] },
                        ]}
                    >
                        <Box gridArea="list">
                            <List primaryKey="name" data={[
                                {name: "Abc"},
                                {name: "Bcd"},
                                {name: "Cde"},
                                {name: "Def"},
                            ]}
                            />
                        </Box>
                        <Box gridArea="viewer">
                            <List primaryKey="name" data={[
                                {name: "Abc"},
                                {name: "Bcd"},
                                {name: "Cde"},
                                {name: "Def"},
                            ]}
                            />
                        </Box>
                    </Grid>
                </Grommet>
            </ServiceProvider>
        )
    });