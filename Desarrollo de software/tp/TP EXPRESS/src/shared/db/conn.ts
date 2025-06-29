import {MongoClient, Db} from 'mongodb';

const conec = 'mongodb://localhost:27017/';

const cli = new MongoClient(conec);
await cli.connect()

export let db: Db = cli.db('Ferrocarril')

