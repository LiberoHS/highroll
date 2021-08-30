export interface HearthstoneCard {
    id: string;
    name: string;
    text?: string;
    image: string;
}

export interface DiscoverResults {
    total: number;
    results: HearthstoneCard[];
}