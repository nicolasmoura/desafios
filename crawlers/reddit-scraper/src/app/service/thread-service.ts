import {Injectable} from "@angular/core";
import {HttpClient, HttpParams} from "@angular/common/http";
import {Thread} from "../model/thread";
import {Observable} from "rxjs/Observable";
import {environment} from '../../environments/environment'
@Injectable()
export class ThreadService {

    constructor(private http: HttpClient) {}

    getHotThreads(subreddits: string): Observable<Array<Thread>> {
        return this.http.get<Array<Thread>>(environment.API_ENDPOINT + '/threads/hot', {
            params: new HttpParams().set('subreddits', subreddits)
        });
    }
}
