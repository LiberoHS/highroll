export type DeckIdentifier = "Demon Hunter" | "Druid" | "Hunter" | "Mage" | "Paladin" | "Priest" | "Rogue" | "Shaman" | "Warlock" | "Warrior";

export interface DeckClass {
    name: DeckIdentifier;
    imagePath: string;
}

export const deckClasses: DeckClass[] = [
    {
        name: "Demon Hunter",
        imagePath: "assets/class-demon-hunter.png"
    },
    {
        name: "Druid",
        imagePath: "assets/class-druid.png"
    },
    {
        name: "Hunter",
        imagePath: "assets/class-hunter.png"
    },
    {
        name: "Mage",
        imagePath: "assets/class-mage.png"
    },
    {
        name: "Paladin",
        imagePath: "assets/class-paladin.png"
    },
    {
        name: "Priest",
        imagePath: "assets/class-priest.png"
    },
    {
        name: "Rogue",
        imagePath: "assets/class-rogue.png"
    },
    {
        name: "Shaman",
        imagePath: "assets/class-shaman.png"
    },
    {
        name: "Warlock",
        imagePath: "assets/class-warlock.png"
    },
    {
        name: "Warrior",
        imagePath: "assets/class-warrior.png"
    }
];