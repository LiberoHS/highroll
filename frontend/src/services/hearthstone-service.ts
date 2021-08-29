export class HearthstoneService {
    rootUrl: string;

    constructor() {
        this.rootUrl = "http://localhost:8080";
    }

    public getDiscoverableCards = async (card: string, deckClass: string) => {
        return fetch(`${this.rootUrl}/api/card/search?` + new URLSearchParams({
            card: card,
            deckClass: deckClass
        }), {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
                "Access-Control-Allow-Origin": "*"
            },
        })
            .then((response) => {
                if (!response.ok) {
                    throw new Error(`Status: ${response.status}`);
                }
                return response.json();
            })
            .catch((err) => {
                console.error("Cannot search for cards:", err);
            });
    };
}