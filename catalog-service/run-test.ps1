$ErrorActionPreference = "Continue"
cd "C:\Curso EPAM JAVA\spring-boot-microservices-bookstore\catalog-service"

Write-Host "=== Ejecutando test ProductControllerTest ===" -ForegroundColor Green

# Intentar con mvnw.cmd
if (Test-Path "mvnw.cmd") {
    Write-Host "Usando mvnw.cmd..." -ForegroundColor Yellow
    & .\mvnw.cmd test -Dtest=ProductControllerTest 2>&1 | Tee-Object -FilePath "test-output.log"

    if ($LASTEXITCODE -eq 0) {
        Write-Host "`n=== TEST EXITOSO ===" -ForegroundColor Green
    } else {
        Write-Host "`n=== TEST FALLIDO ===" -ForegroundColor Red
        Write-Host "Código de salida: $LASTEXITCODE" -ForegroundColor Red
    }
} else {
    Write-Host "mvnw.cmd no encontrado" -ForegroundColor Red
}

# Mostrar las últimas líneas del log
if (Test-Path "test-output.log") {
    Write-Host "`n=== ÚLTIMAS LÍNEAS DEL LOG ===" -ForegroundColor Cyan
    Get-Content "test-output.log" | Select-Object -Last 50
}

