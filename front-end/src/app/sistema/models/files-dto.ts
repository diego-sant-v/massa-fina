import { UserRegisterDTO } from "./user-register-dto";

export class FilesDTO{
    public id: number;
    public userLoggedDTO: UserRegisterDTO;
    public relativePath: string;
    public file: boolean;
    public image: boolean;

    constructor(id: number, userLoggedDTO: UserRegisterDTO, relativePath: string, file: boolean, image: boolean){
        this.id = id;
        this.userLoggedDTO = userLoggedDTO;
        this.relativePath = relativePath;
        this.file = file
        this.image = image
    }
}