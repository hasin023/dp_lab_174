const axios = require('axios');

const JAVA_SERVER_URL = process.env.SERVER_URL;


class EncryptController {

    renderEncrypt = async (req: any, res: any) => {
        res.json({ message: 'Rendering from encrypt' });
    };

    renderDecrypt = async (req: any, res: any) => {
        res.json({ message: 'Rendering from decrypt' });
    };

    encrypt = async (req: any, res: any) => {
        try {
            const { data, encryptionType } = req.body;

            const response = await axios.post(`${JAVA_SERVER_URL}/encrypt`, {
                data,
                encryptionType
            });

            res.json({ encryptedData: response.data.encryptedData });
        } catch (error) {
            console.error(error);
            res.status(500).send('Error during encryption');
        }
    };

    decrypt = async (req: any, res: any) => {
        try {
            const { encryptedData, encryptionType } = req.body;

            const response = await axios.post(`${JAVA_SERVER_URL}/decrypt`, {
                encryptedData,
                encryptionType
            });

            res.json({ decryptedData: response.data.decryptedData });
        } catch (error) {
            console.error(error);
            res.status(500).send('Error during decryption');
        }
    };

}

module.exports = new EncryptController();