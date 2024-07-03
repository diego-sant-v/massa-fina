import { Component } from '@angular/core';
import { FileUploadService } from '../../services/file/file-service.service';

@Component({
  selector: 'app-upload-image-modal',
  templateUrl: './upload-image-modal.component.html',
  styleUrls: ['./upload-image-modal.component.scss']
})
export class UploadImageModalComponent {
  selectedFile: File | null = null; // Inicialize selectedFile como null
  imageUrl: any;

  constructor(private fileService: FileUploadService) { }

  onFileSelected(event: any): void {
    this.selectedFile = event.target.files[0] as File;
    // Criar um objeto URL temporário para a pré-visualização
    if (this.selectedFile) {
      const reader = new FileReader();
      reader.onload = () => {
        this.imageUrl = reader.result;
      };
      reader.readAsDataURL(this.selectedFile);
    }
  }

  upload(): void {
    if (this.selectedFile) {
      this.fileService.uploadFile(this.selectedFile).subscribe(
        response => {
          console.log('File uploaded successfully!', response);
          // Aqui você pode lidar com a resposta do servidor, se necessário.
        },
        error => {
          console.error('Error uploading file:', error);
          // Aqui você pode lidar com o erro, se necessário.
        }
      );
    } else {
      console.error('No file selected.');
    }
  }
}
