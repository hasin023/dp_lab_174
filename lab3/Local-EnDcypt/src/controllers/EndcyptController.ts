const CryptoJS = require("crypto-js");

class EncryptController {
    private readonly secretKey = "55VoicesInMyHead";

    renderEncrypt = async (req: any, res: any) => {
        res.json({ message: 'Rendering from encrypt' });
    };

    renderDecrypt = async (req: any, res: any) => {
        res.json({ message: 'Rendering from decrypt' });
    };

    encrypt = async (req: any, res: any) => {
        const { text, method } = req.body;

        if (!text) {
            return res.status(400).json({ message: 'Text is required' });
        }

        if (!method) {
            return res.status(400).json({ message: 'Method is required' });
        }


        if (method === 'AES') {
            const encrypted = CryptoJS.AES.encrypt(text, this.secretKey).toString();
            return res.json({
                message: `Encrypting text via ${method} => ${text}`,
                encryptedText: encrypted
            });
        } else if (method === 'DES') {
            const encrypted = CryptoJS.DES.encrypt(text, this.secretKey).toString();
            return res.json({
                message: `Encrypting text via ${method} => ${text}`,
                encryptedText: encrypted
            });
        }

        res.json({ message: `Keep your secrets safe <33` });
    };

    decrypt = async (req: any, res: any) => {
        const { text, method } = req.body;

        if (!text) {
            return res.status(400).json({ message: 'Text is required' });
        }

        if (!method) {
            return res.status(400).json({ message: 'Method is required' });
        }


        if (method === 'AES') {
            const bytes = CryptoJS.AES.decrypt(text, this.secretKey);
            const decrypted = bytes.toString(CryptoJS.enc.Utf8);
            return res.json({
                message: `Decrypting text via ${method} => ${text}`,
                decryptedText: decrypted
            });
        } else if (method === 'DES') {
            const bytes = CryptoJS.DES.decrypt(text, this.secretKey);
            const decrypted = bytes.toString(CryptoJS.enc.Utf8);
            return res.json({
                message: `Decrypting text via ${method} => ${text}`,
                decryptedText: decrypted
            });
        }

        res.json({ message: `Now we know your secrets :33` });
    };
}

module.exports = new EncryptController();