export class Thread {
    private _title: string;
    private _upvotes: number;
    private _permalink: string;
    private _link: string;
    private _subreddit: string;

    constructor(title: string, upvotes: number, permalink: string, link: string, subreddit: string) {
        this._title = title;
        this._upvotes = upvotes;
        this._permalink = permalink;
        this._link = link;
        this._subreddit = subreddit;
    }

    get title(): string {
        return this._title;
    }

    get upvotes(): number {
        return this._upvotes;
    }

    get permalink(): string {
        return this._permalink;
    }

    get link(): string {
        return this._link;
    }

    get subreddit(): string {
        return this._subreddit;
    }
}
